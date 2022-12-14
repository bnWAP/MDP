package edu.miu.resume_app.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.resume_app.adapter.MyViewAdapter
import edu.miu.resume_app.models.WorkExperience
import edu.miu.resume_app.ui.dialog.ThemeCallback
import edu.miu.resume_app.ui.dialog.SettingsDialog
import edu.miu.resume_app.ui.dialog.WorkExperienceDialogCallback
import edu.miu.resume_app.utils.AppUtils


class HomeActivity : AppCompatActivity(), ThemeCallback, WorkExperienceDialogCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val theme = AppUtils.getPref(getString(R.string.saved_theme), this)
        val user = AppUtils.getPref(getString(R.string.login_user_key), this)
        if (theme != null) AppUtils.decideTheme(theme)

        showWorkDialog()
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.home_menu)
                1 -> tab.text = getString(R.string.about_me_menu)
                2 -> tab.text = getString(R.string.work_menu)
                3 -> tab.text = getString(R.string.contact_menu)
            }
        }.attach()


        user?.apply { binding.toolbar.title = "Bara's Resume" }
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_main_setting -> {
                    showNoticeDialog()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_main_logout -> {
                    finish()
                    return@setOnMenuItemClickListener true
                }
                else -> false
            }
        }
    }

    private fun showNoticeDialog() {
        val dialog = SettingsDialog()
        dialog.show(supportFragmentManager, SettingsDialog::class.java.name)
    }

    override fun onChangeTheme(theme: String) {
        with(AppUtils.getSharedPref(this).edit()) {
            putString(getString(R.string.saved_theme), theme)
            apply()
        }
        AppUtils.decideTheme(theme)
    }

    private fun showWorkDialog() {
        adapter = MyViewAdapter(supportFragmentManager, lifecycle)
        binding.pager.adapter = adapter
    }

    override fun onWorkExperienceAdded(workExperience: WorkExperience) {
        if (::adapter.isInitialized) {
            adapter.addWork(workExperience)
        } else {
            showWorkDialog()
            adapter.addWork(workExperience)
        }
    }

}