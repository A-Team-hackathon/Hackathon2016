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
import org.pontis.hackathon.textanalytics.client.model.InternalError;


/**
 * InternalError
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-15T16:43:13.271+02:00")
public class InternalError   {
  /**
   * Gets or Sets code
   */
  public enum CodeEnum {
    @SerializedName("invalidParameterValue")
    INVALIDPARAMETERVALUE("invalidParameterValue"),
    
    @SerializedName("invalidRequestBodyFormat")
    INVALIDREQUESTBODYFORMAT("invalidRequestBodyFormat"),
    
    @SerializedName("missingRequiredHeader")
    MISSINGREQUIREDHEADER("missingRequiredHeader"),
    
    @SerializedName("invalidRequestContent")
    INVALIDREQUESTCONTENT("invalidRequestContent"),
    
    @SerializedName("missingRequiredParameter")
    MISSINGREQUIREDPARAMETER("missingRequiredParameter");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("code")
  private CodeEnum code = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("innerError")
  private InternalError innerError = null;

  public InternalError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(example = "null", value = "")
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public InternalError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public InternalError innerError(InternalError innerError) {
    this.innerError = innerError;
    return this;
  }

   /**
   * Get innerError
   * @return innerError
  **/
  @ApiModelProperty(example = "null", value = "")
  public InternalError getInnerError() {
    return innerError;
  }

  public void setInnerError(InternalError innerError) {
    this.innerError = innerError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternalError internalError = (InternalError) o;
    return Objects.equals(this.code, internalError.code) &&
        Objects.equals(this.message, internalError.message) &&
        Objects.equals(this.innerError, internalError.innerError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, innerError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternalError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    innerError: ").append(toIndentedString(innerError)).append("\n");
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

