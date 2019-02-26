/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class MeasurementUploadEvent extends APINode {
  @SerializedName("aggregation_level")
  private String mAggregationLevel = null;
  @SerializedName("conversion_end_date")
  private String mConversionEndDate = null;
  @SerializedName("conversion_start_date")
  private String mConversionStartDate = null;
  @SerializedName("event_status")
  private String mEventStatus = null;
  @SerializedName("group")
  private String mGroup = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("lookback_window")
  private String mLookbackWindow = null;
  @SerializedName("match_universe")
  private String mMatchUniverse = null;
  @SerializedName("partner")
  private Business mPartner = null;
  @SerializedName("upload_end_time")
  private String mUploadEndTime = null;
  @SerializedName("upload_start_time")
  private String mUploadStartTime = null;
  @SerializedName("upload_tag")
  private String mUploadTag = null;
  @SerializedName("version")
  private String mVersion = null;
  protected static Gson gson = null;

  MeasurementUploadEvent() {
  }

  public MeasurementUploadEvent(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MeasurementUploadEvent(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MeasurementUploadEvent fetch() throws APIException{
    MeasurementUploadEvent newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MeasurementUploadEvent fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MeasurementUploadEvent> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MeasurementUploadEvent fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MeasurementUploadEvent> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MeasurementUploadEvent> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MeasurementUploadEvent>)(
      new APIRequest<MeasurementUploadEvent>(context, "", "/", "GET", MeasurementUploadEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MeasurementUploadEvent>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MeasurementUploadEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static MeasurementUploadEvent loadJSON(String json, APIContext context, String header) {
    MeasurementUploadEvent measurementUploadEvent = getGson().fromJson(json, MeasurementUploadEvent.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(measurementUploadEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    measurementUploadEvent.context = context;
    measurementUploadEvent.rawValue = json;
    measurementUploadEvent.header = header;
    return measurementUploadEvent;
  }

  public static APINodeList<MeasurementUploadEvent> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MeasurementUploadEvent> measurementUploadEvents = new APINodeList<MeasurementUploadEvent>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          measurementUploadEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return measurementUploadEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                measurementUploadEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            measurementUploadEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              measurementUploadEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              measurementUploadEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  measurementUploadEvents.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              measurementUploadEvents.add(loadJSON(obj.toString(), context, header));
            }
          }
          return measurementUploadEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              measurementUploadEvents.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return measurementUploadEvents;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              measurementUploadEvents.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return measurementUploadEvents;
          }

          // Sixth, check if it's pure JsonObject
          measurementUploadEvents.clear();
          measurementUploadEvents.add(loadJSON(json, context, header));
          return measurementUploadEvents;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAggregationLevel() {
    return mAggregationLevel;
  }

  public String getFieldConversionEndDate() {
    return mConversionEndDate;
  }

  public String getFieldConversionStartDate() {
    return mConversionStartDate;
  }

  public String getFieldEventStatus() {
    return mEventStatus;
  }

  public String getFieldGroup() {
    return mGroup;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLookbackWindow() {
    return mLookbackWindow;
  }

  public String getFieldMatchUniverse() {
    return mMatchUniverse;
  }

  public Business getFieldPartner() {
    if (mPartner != null) {
      mPartner.context = getContext();
    }
    return mPartner;
  }

  public String getFieldUploadEndTime() {
    return mUploadEndTime;
  }

  public String getFieldUploadStartTime() {
    return mUploadStartTime;
  }

  public String getFieldUploadTag() {
    return mUploadTag;
  }

  public String getFieldVersion() {
    return mVersion;
  }



  public static class APIRequestGet extends APIRequest<MeasurementUploadEvent> {

    MeasurementUploadEvent lastResponse = null;
    @Override
    public MeasurementUploadEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "aggregation_level",
      "conversion_end_date",
      "conversion_start_date",
      "event_status",
      "group",
      "id",
      "lookback_window",
      "match_universe",
      "partner",
      "upload_end_time",
      "upload_start_time",
      "upload_tag",
      "version",
    };

    @Override
    public MeasurementUploadEvent parseResponse(String response, String header) throws APIException {
      return MeasurementUploadEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MeasurementUploadEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementUploadEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MeasurementUploadEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementUploadEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MeasurementUploadEvent>() {
           public MeasurementUploadEvent apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAggregationLevelField () {
      return this.requestAggregationLevelField(true);
    }
    public APIRequestGet requestAggregationLevelField (boolean value) {
      this.requestField("aggregation_level", value);
      return this;
    }
    public APIRequestGet requestConversionEndDateField () {
      return this.requestConversionEndDateField(true);
    }
    public APIRequestGet requestConversionEndDateField (boolean value) {
      this.requestField("conversion_end_date", value);
      return this;
    }
    public APIRequestGet requestConversionStartDateField () {
      return this.requestConversionStartDateField(true);
    }
    public APIRequestGet requestConversionStartDateField (boolean value) {
      this.requestField("conversion_start_date", value);
      return this;
    }
    public APIRequestGet requestEventStatusField () {
      return this.requestEventStatusField(true);
    }
    public APIRequestGet requestEventStatusField (boolean value) {
      this.requestField("event_status", value);
      return this;
    }
    public APIRequestGet requestGroupField () {
      return this.requestGroupField(true);
    }
    public APIRequestGet requestGroupField (boolean value) {
      this.requestField("group", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLookbackWindowField () {
      return this.requestLookbackWindowField(true);
    }
    public APIRequestGet requestLookbackWindowField (boolean value) {
      this.requestField("lookback_window", value);
      return this;
    }
    public APIRequestGet requestMatchUniverseField () {
      return this.requestMatchUniverseField(true);
    }
    public APIRequestGet requestMatchUniverseField (boolean value) {
      this.requestField("match_universe", value);
      return this;
    }
    public APIRequestGet requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGet requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGet requestUploadEndTimeField () {
      return this.requestUploadEndTimeField(true);
    }
    public APIRequestGet requestUploadEndTimeField (boolean value) {
      this.requestField("upload_end_time", value);
      return this;
    }
    public APIRequestGet requestUploadStartTimeField () {
      return this.requestUploadStartTimeField(true);
    }
    public APIRequestGet requestUploadStartTimeField (boolean value) {
      this.requestField("upload_start_time", value);
      return this;
    }
    public APIRequestGet requestUploadTagField () {
      return this.requestUploadTagField(true);
    }
    public APIRequestGet requestUploadTagField (boolean value) {
      this.requestField("upload_tag", value);
      return this;
    }
    public APIRequestGet requestVersionField () {
      return this.requestVersionField(true);
    }
    public APIRequestGet requestVersionField (boolean value) {
      this.requestField("version", value);
      return this;
    }
  }

  public static enum EnumAggregationLevel {
      @SerializedName("DAILY")
      VALUE_DAILY("DAILY"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("WEEKLY")
      VALUE_WEEKLY("WEEKLY"),
      NULL(null);

      private String value;

      private EnumAggregationLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEventStatus {
      @SerializedName("CANCELCOMPLETED")
      VALUE_CANCELCOMPLETED("CANCELCOMPLETED"),
      @SerializedName("CANCELED")
      VALUE_CANCELED("CANCELED"),
      @SerializedName("COMPLETED")
      VALUE_COMPLETED("COMPLETED"),
      @SerializedName("FAILED")
      VALUE_FAILED("FAILED"),
      @SerializedName("STARTED")
      VALUE_STARTED("STARTED"),
      @SerializedName("UPLOADED")
      VALUE_UPLOADED("UPLOADED"),
      NULL(null);

      private String value;

      private EnumEventStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGroup {
      @SerializedName("MONDAY")
      VALUE_MONDAY("MONDAY"),
      @SerializedName("SUNDAY")
      VALUE_SUNDAY("SUNDAY"),
      NULL(null);

      private String value;

      private EnumGroup(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLookbackWindow {
      @SerializedName("DAYS30")
      VALUE_DAYS30("DAYS30"),
      @SerializedName("DAYS45")
      VALUE_DAYS45("DAYS45"),
      @SerializedName("DAYS60")
      VALUE_DAYS60("DAYS60"),
      @SerializedName("DAYS90")
      VALUE_DAYS90("DAYS90"),
      NULL(null);

      private String value;

      private EnumLookbackWindow(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMatchUniverse {
      @SerializedName("FULL")
      VALUE_FULL("FULL"),
      @SerializedName("PII")
      VALUE_PII("PII"),
      @SerializedName("PIXEL")
      VALUE_PIXEL("PIXEL"),
      NULL(null);

      private String value;

      private EnumMatchUniverse(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVersion {
      @SerializedName("EVALUATION")
      VALUE_EVALUATION("EVALUATION"),
      @SerializedName("WEEKLY")
      VALUE_WEEKLY("WEEKLY"),
      NULL(null);

      private String value;

      private EnumVersion(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public MeasurementUploadEvent copyFrom(MeasurementUploadEvent instance) {
    this.mAggregationLevel = instance.mAggregationLevel;
    this.mConversionEndDate = instance.mConversionEndDate;
    this.mConversionStartDate = instance.mConversionStartDate;
    this.mEventStatus = instance.mEventStatus;
    this.mGroup = instance.mGroup;
    this.mId = instance.mId;
    this.mLookbackWindow = instance.mLookbackWindow;
    this.mMatchUniverse = instance.mMatchUniverse;
    this.mPartner = instance.mPartner;
    this.mUploadEndTime = instance.mUploadEndTime;
    this.mUploadStartTime = instance.mUploadStartTime;
    this.mUploadTag = instance.mUploadTag;
    this.mVersion = instance.mVersion;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MeasurementUploadEvent> getParser() {
    return new APIRequest.ResponseParser<MeasurementUploadEvent>() {
      public APINodeList<MeasurementUploadEvent> parseResponse(String response, APIContext context, APIRequest<MeasurementUploadEvent> request, String header) throws MalformedResponseException {
        return MeasurementUploadEvent.parseResponse(response, context, request, header);
      }
    };
  }
}