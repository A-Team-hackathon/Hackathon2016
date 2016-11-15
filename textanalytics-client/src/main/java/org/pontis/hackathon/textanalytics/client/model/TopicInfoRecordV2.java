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


/**
 * TopicInfoRecordV2
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T16:43:13.271+02:00")
public class TopicInfoRecordV2   {
  @SerializedName("id")
  private String id = null;

  @SerializedName("score")
  private Double score = null;

  @SerializedName("keyPhrase")
  private String keyPhrase = null;

  public TopicInfoRecordV2 id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier for each topic.
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "A unique identifier for each topic.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TopicInfoRecordV2 score(Double score) {
    this.score = score;
    return this;
  }

   /**
   * Count of documents assigned to topic.
   * @return score
  **/
  @ApiModelProperty(example = "null", value = "Count of documents assigned to topic.")
  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public TopicInfoRecordV2 keyPhrase(String keyPhrase) {
    this.keyPhrase = keyPhrase;
    return this;
  }

   /**
   * A summarizing word or phrase for the topic.
   * @return keyPhrase
  **/
  @ApiModelProperty(example = "null", value = "A summarizing word or phrase for the topic.")
  public String getKeyPhrase() {
    return keyPhrase;
  }

  public void setKeyPhrase(String keyPhrase) {
    this.keyPhrase = keyPhrase;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopicInfoRecordV2 topicInfoRecordV2 = (TopicInfoRecordV2) o;
    return Objects.equals(this.id, topicInfoRecordV2.id) &&
        Objects.equals(this.score, topicInfoRecordV2.score) &&
        Objects.equals(this.keyPhrase, topicInfoRecordV2.keyPhrase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, score, keyPhrase);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopicInfoRecordV2 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    keyPhrase: ").append(toIndentedString(keyPhrase)).append("\n");
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

