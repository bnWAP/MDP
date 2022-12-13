package edu.miu.resume_app.ui.dialog

import edu.miu.resume_app.models.WorkExperience

interface WorkExperienceDialogCallback {
    fun onWorkExperienceAdded(workExperience: WorkExperience)
}