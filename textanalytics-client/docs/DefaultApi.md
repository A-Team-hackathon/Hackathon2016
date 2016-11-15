# DefaultApi

All URIs are relative to *https://westus.api.cognitive.microsoft.com/text/analytics/v2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**detectLanguage**](DefaultApi.md#detectLanguage) | **POST** /languages | 
[**detectTopics**](DefaultApi.md#detectTopics) | **POST** /topics | 
[**keyPhrases**](DefaultApi.md#keyPhrases) | **POST** /keyPhrases | 
[**operationStatus**](DefaultApi.md#operationStatus) | **GET** /operations/{operationId} | 
[**sentiment**](DefaultApi.md#sentiment) | **POST** /sentiment | 


<a name="detectLanguage"></a>
# **detectLanguage**
> LanguageBatchResultV2 detectLanguage(numberOfLanguagesToDetect, subscriptionKey, ocpApimSubscriptionKey, batchInputV2)



The API returns the detected language and a numeric score between 0 and 1.               Scores close to 1 indicate 100% certainty that the identified language is true.               A total of 120 languages are supported.

### Example
```java
// Import classes:
//import org.pontis.hackathon.ApiException;
//import org.pontis.hackathon.textanalytics.client.api.DefaultApi;


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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **numberOfLanguagesToDetect** | **Integer**| Format - int32. (Optional) Number of languages to detect. Set to 1 by default. | [optional]
 **subscriptionKey** | **String**| subscription key in url | [optional]
 **ocpApimSubscriptionKey** | **String**| subscription key in header | [optional]
 **batchInputV2** | [**BatchInputV2**](BatchInputV2.md)|  | [optional]

### Return type

[**LanguageBatchResultV2**](LanguageBatchResultV2.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json
 - **Accept**: application/json, text/json

<a name="detectTopics"></a>
# **detectTopics**
> detectTopics(minDocumentsPerWord, maxDocumentsPerWord, subscriptionKey, ocpApimSubscriptionKey, topicDetectionInputV2)



The API returns the top detected topics for a list of submitted text documents.               A topic is identified with a key phrase, which can be one or more related words.               Use the URL parameters and stop word list to control which words or documents are filtered out.               You can also supply a list of topics to exclude from the response.               At least 100 text documents must be submitted, however it is designed to detect topics across hundreds to thousands of documents.               Note that one transaction is charged per text document submitted.               For best performance, limit each document to a short, human written text paragraph such as review, conversation or user feedback.

### Example
```java
// Import classes:
//import org.pontis.hackathon.ApiException;
//import org.pontis.hackathon.textanalytics.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer minDocumentsPerWord = 56; // Integer | Format - int32. (optional) Words that occur in less than this many documents are ignored.               Use this parameter to help exclude rare document topics.              Omit to let the service choose appropriate value.
Integer maxDocumentsPerWord = 56; // Integer | Format - int32. (optional) Words that occur in more than this many documents are ignored.               Use this parameter to help exclude ubiquitous document topics.              Omit to let the service choose appropriate value.
String subscriptionKey = "subscriptionKey_example"; // String | subscription key in url
String ocpApimSubscriptionKey = "ocpApimSubscriptionKey_example"; // String | subscription key in header
TopicDetectionInputV2 topicDetectionInputV2 = new TopicDetectionInputV2(); // TopicDetectionInputV2 | 
try {
    apiInstance.detectTopics(minDocumentsPerWord, maxDocumentsPerWord, subscriptionKey, ocpApimSubscriptionKey, topicDetectionInputV2);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#detectTopics");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **minDocumentsPerWord** | **Integer**| Format - int32. (optional) Words that occur in less than this many documents are ignored.               Use this parameter to help exclude rare document topics.              Omit to let the service choose appropriate value. | [optional]
 **maxDocumentsPerWord** | **Integer**| Format - int32. (optional) Words that occur in more than this many documents are ignored.               Use this parameter to help exclude ubiquitous document topics.              Omit to let the service choose appropriate value. | [optional]
 **subscriptionKey** | **String**| subscription key in url | [optional]
 **ocpApimSubscriptionKey** | **String**| subscription key in header | [optional]
 **topicDetectionInputV2** | [**TopicDetectionInputV2**](TopicDetectionInputV2.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json
 - **Accept**: application/json, text/json

<a name="keyPhrases"></a>
# **keyPhrases**
> KeyPhraseBatchResultV2 keyPhrases(subscriptionKey, ocpApimSubscriptionKey, multiLanguageBatchInputV2)



The API returns a list of strings denoting the key talking points in the input text.               We employ techniques from Microsoft Office&#39;s sophisticated Natural Language Processing toolkit.               Currently, the following languages are supported: English, German, Spanish and Japanese.

### Example
```java
// Import classes:
//import org.pontis.hackathon.ApiException;
//import org.pontis.hackathon.textanalytics.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String subscriptionKey = "subscriptionKey_example"; // String | subscription key in url
String ocpApimSubscriptionKey = "ocpApimSubscriptionKey_example"; // String | subscription key in header
MultiLanguageBatchInputV2 multiLanguageBatchInputV2 = new MultiLanguageBatchInputV2(); // MultiLanguageBatchInputV2 | 
try {
    KeyPhraseBatchResultV2 result = apiInstance.keyPhrases(subscriptionKey, ocpApimSubscriptionKey, multiLanguageBatchInputV2);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#keyPhrases");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| subscription key in url | [optional]
 **ocpApimSubscriptionKey** | **String**| subscription key in header | [optional]
 **multiLanguageBatchInputV2** | [**MultiLanguageBatchInputV2**](MultiLanguageBatchInputV2.md)|  | [optional]

### Return type

[**KeyPhraseBatchResultV2**](KeyPhraseBatchResultV2.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json
 - **Accept**: application/json, text/json

<a name="operationStatus"></a>
# **operationStatus**
> OperationResult operationStatus(operationId, subscriptionKey, ocpApimSubscriptionKey)



Get the status of an operation submitted for processing. If the the operation has reached a &#39;Succeeded&#39; state, will also return the result.

### Example
```java
// Import classes:
//import org.pontis.hackathon.ApiException;
//import org.pontis.hackathon.textanalytics.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String operationId = "operationId_example"; // String | A unique id for the submitted operation.
String subscriptionKey = "subscriptionKey_example"; // String | subscription key in url
String ocpApimSubscriptionKey = "ocpApimSubscriptionKey_example"; // String | subscription key in header
try {
    OperationResult result = apiInstance.operationStatus(operationId, subscriptionKey, ocpApimSubscriptionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#operationStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **operationId** | **String**| A unique id for the submitted operation. |
 **subscriptionKey** | **String**| subscription key in url | [optional]
 **ocpApimSubscriptionKey** | **String**| subscription key in header | [optional]

### Return type

[**OperationResult**](OperationResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json

<a name="sentiment"></a>
# **sentiment**
> SentimentBatchResultV2 sentiment(subscriptionKey, ocpApimSubscriptionKey, multiLanguageBatchInputV2)



The API returns a numeric score between 0 and 1.               Scores close to 1 indicate positive sentiment, while scores close to 0 indicate negative sentiment.               Sentiment score is generated using classification techniques.               The input features to the classifier include n-grams, features generated from part-of-speech tags, and word embeddings.               Currently, the following languages are supported: English, Spanish, French, Portuguese.

### Example
```java
// Import classes:
//import org.pontis.hackathon.ApiException;
//import org.pontis.hackathon.textanalytics.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String subscriptionKey = "subscriptionKey_example"; // String | subscription key in url
String ocpApimSubscriptionKey = "ocpApimSubscriptionKey_example"; // String | subscription key in header
MultiLanguageBatchInputV2 multiLanguageBatchInputV2 = new MultiLanguageBatchInputV2(); // MultiLanguageBatchInputV2 | 
try {
    SentimentBatchResultV2 result = apiInstance.sentiment(subscriptionKey, ocpApimSubscriptionKey, multiLanguageBatchInputV2);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sentiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| subscription key in url | [optional]
 **ocpApimSubscriptionKey** | **String**| subscription key in header | [optional]
 **multiLanguageBatchInputV2** | [**MultiLanguageBatchInputV2**](MultiLanguageBatchInputV2.md)|  | [optional]

### Return type

[**SentimentBatchResultV2**](SentimentBatchResultV2.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json
 - **Accept**: application/json, text/json

