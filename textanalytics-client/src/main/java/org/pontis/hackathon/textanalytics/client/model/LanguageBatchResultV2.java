/**
 * Azure Machine Learning - Text Analytics
 * The Text Analytics API is a suite of text analytics web services built with Azure Machine Learning.   The API can be used to analyze unstructured text for tasks such as sentiment analysis, key phrase extraction and language detection.   No training data is needed to use this API; just bring your text data.   This API uses advanced natural language processing techniques to deliver best in class predictions.    Further documentation can be found in https://azure.microsoft.com/en-us/documentation/articles/machine-learning-apps-text-analytics/
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.pontis.hackathon.textanalytics.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.pontis.hackathon.textanalytics.client.model.ErrorRecordV2;
import org.pontis.hackathon.textanalytics.client.model.LanguageBatchResultItemV2;


/**
 * LanguageBatchResultV2
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T16:43:13.271+02:00")
public class LanguageBatchResultV2   {
  @SerializedName("documents")
  private List<LanguageBatchResultItemV2> documents = new ArrayList<LanguageBatchResultItemV2>();

  @SerializedName("errors")
  private List<ErrorRecordV2> errors = new ArrayList<ErrorRecordV2>();

  public LanguageBatchResultV2 documents(List<LanguageBatchResultItemV2> documents) {
    this.documents = documents;
    return this;
  }

  public LanguageBatchResultV2 addDocumentsItem(LanguageBatchResultItemV2 documentsItem) {
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * Get documents
   * @return documents
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<LanguageBatchResultItemV2> getDocuments() {
    return documents;
  }

  public void setDocuments(List<LanguageBatchResultItemV2> documents) {
    this.documents = documents;
  }

  public LanguageBatchResultV2 errors(List<ErrorRecordV2> errors) {
    this.errors = errors;
    return this;
  }

  public LanguageBatchResultV2 addErrorsItem(ErrorRecordV2 errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * Get errors
   * @return errors
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ErrorRecordV2> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorRecordV2> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LanguageBatchResultV2 languageBatchResultV2 = (LanguageBatchResultV2) o;
    return Objects.equals(this.documents, languageBatchResultV2.documents) &&
        Objects.equals(this.errors, languageBatchResultV2.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documents, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LanguageBatchResultV2 {\n");
    
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

