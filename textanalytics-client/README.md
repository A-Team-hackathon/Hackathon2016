# textanalytics.client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.pontis.hackathon</groupId>
    <artifactId>textanalytics.client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.pontis.hackathon:textanalytics.client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/textanalytics.client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.pontis.hackathon.*;
import org.pontis.hackathon.auth.*;
import org.pontis.hackathon.model.*;
import org.pontis.hackathon.textanalytics.client.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        Integer numberOfLanguagesToDetect = 56; // Integer | Format - int32. (Optional) Number of languages to detect. Set to 1 by default.
        String subscriptionKey = "subscriptionKey_example"; // String | subscription key in url
        String ocpApimSubscriptionKey = "ocpApimSubscriptionKey_example"; // String | subscription key in header
        BatchInputV2 batchInputV2 = new BatchInputV2(); // BatchInputV2 | 
        try {
            LanguageBatchResultV2 result = apiInstance.detectLanguage(numberOfLanguagesToDetect, subscriptionKey, ocpApimSubscriptionKey, batchInputV2);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#detectLanguage");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://westus.api.cognitive.microsoft.com/text/analytics/v2.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**detectLanguage**](docs/DefaultApi.md#detectLanguage) | **POST** /languages | 
*DefaultApi* | [**detectTopics**](docs/DefaultApi.md#detectTopics) | **POST** /topics | 
*DefaultApi* | [**keyPhrases**](docs/DefaultApi.md#keyPhrases) | **POST** /keyPhrases | 
*DefaultApi* | [**operationStatus**](docs/DefaultApi.md#operationStatus) | **GET** /operations/{operationId} | 
*DefaultApi* | [**sentiment**](docs/DefaultApi.md#sentiment) | **POST** /sentiment | 


## Documentation for Models

 - [BatchInputV2](docs/BatchInputV2.md)
 - [DetectedLanguageV2](docs/DetectedLanguageV2.md)
 - [ErrorRecordV2](docs/ErrorRecordV2.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [InputV2](docs/InputV2.md)
 - [InternalError](docs/InternalError.md)
 - [KeyPhraseBatchResultItemV2](docs/KeyPhraseBatchResultItemV2.md)
 - [KeyPhraseBatchResultV2](docs/KeyPhraseBatchResultV2.md)
 - [LanguageBatchResultItemV2](docs/LanguageBatchResultItemV2.md)
 - [LanguageBatchResultV2](docs/LanguageBatchResultV2.md)
 - [MultiLanguageBatchInputV2](docs/MultiLanguageBatchInputV2.md)
 - [MultiLanguageInputV2](docs/MultiLanguageInputV2.md)
 - [Object](docs/Object.md)
 - [OperationProcessingResult](docs/OperationProcessingResult.md)
 - [OperationResult](docs/OperationResult.md)
 - [SentimentBatchResultItemV2](docs/SentimentBatchResultItemV2.md)
 - [SentimentBatchResultV2](docs/SentimentBatchResultV2.md)
 - [TopicAssignmentRecordV2](docs/TopicAssignmentRecordV2.md)
 - [TopicDetectionInputV2](docs/TopicDetectionInputV2.md)
 - [TopicDetectionResultV2](docs/TopicDetectionResultV2.md)
 - [TopicInfoRecordV2](docs/TopicInfoRecordV2.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



