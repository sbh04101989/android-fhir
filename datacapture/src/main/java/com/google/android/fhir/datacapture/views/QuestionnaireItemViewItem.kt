/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.datacapture.views

import androidx.recyclerview.widget.RecyclerView
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent

/**
 * Item for [QuestionnaireItemViewHolder] in [RecyclerView] containing [QuestionnaireItemComponent]
 * (the question) and [QuestionnaireResponseItemComponent] (the answer).
 *
 * [QuestionnaireItemComponent] (the question) and [QuestionnaireResponseItemComponent] (the answer)
 * are used to create the right type of view (e.g. a CheckBox for a yes/no question) and populate
 * the view with the right information (e.g text for the CheckBox and initial yes/no answer for the
 * CheckBox).
 */
data class QuestionnaireItemViewItem(
  val questionnaireItemComponent: QuestionnaireItemComponent,
  val questionnaireResponseItemComponent: QuestionnaireResponseItemComponent
) {
  /**
   * The single answer to the [QuestionnaireItemComponent], or `null` if there is none or more than
   * one answer.
   */
  var singleAnswerOrNull
    get() = questionnaireResponseItemComponent.answer.singleOrNull()
    set(value) {
      questionnaireResponseItemComponent.answer = listOf(value)
    }
}
