
# OperationResult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | Operation status. |  [optional]
**createdDateTime** | [**DateTime**](DateTime.md) | Operation creation date time (ISO 8601 literal). |  [optional]
**lastActionDateTime** | [**DateTime**](DateTime.md) | Operation last status change date time (ISO 8601 literal). |  [optional]
**operationType** | **String** | Name of API endpoint that created the operation. |  [optional]
**operationProcessingResult** | [**OperationProcessingResult**](OperationProcessingResult.md) | Operation result. Specific format varies according to the operation type. Exists only in case the operation has reached a &#39;Succeeded&#39; state. |  [optional]
**message** | **String** | Error message. Exists only in case the operation has reached a &#39;Failed&#39; state. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NOTSTARTED | &quot;notStarted&quot;
RUNNING | &quot;running&quot;
FAILED | &quot;failed&quot;
CANCELLED | &quot;cancelled&quot;
SUCCEEDED | &quot;succeeded&quot;



