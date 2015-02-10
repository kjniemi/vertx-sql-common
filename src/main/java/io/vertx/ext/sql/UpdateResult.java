package io.vertx.ext.sql;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@DataObject
public class UpdateResult {

  private int updated;
  private JsonArray keys;

  public UpdateResult() {
  }

  public UpdateResult(UpdateResult other) {
    this.updated = other.updated;
    this.keys = other.getKeys();
  }

  @SuppressWarnings("unchecked")
  public UpdateResult(JsonObject json) {
    this.updated = json.getInteger("updated");
    keys = json.getJsonArray("keys");
  }

  public UpdateResult(int updated, JsonArray keys) {
    this.updated = updated;
    this.keys = keys;
  }

  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    obj.put("updated", updated);
    obj.put("keys", keys);
    return obj;
  }

  public int getUpdated() {
    return updated;
  }

  public JsonArray getKeys() {
    return keys;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UpdateResult that = (UpdateResult) o;

    if (updated != that.updated) return false;
    if (keys != null ? !keys.equals(that.keys) : that.keys != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = updated;
    result = 31 * result + (keys != null ? keys.hashCode() : 0);
    return result;
  }
}