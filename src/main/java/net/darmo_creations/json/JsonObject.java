package net.darmo_creations.json;

import java.util.HashMap;
import java.util.Map;

public final class JsonObject extends HashMap<String, JsonBase> implements JsonBase {
  private static final long serialVersionUID = -1090220898175859874L;

  public JsonObject() {
    super();
  }

  public JsonObject(int initialCapacity) {
    super(initialCapacity);
  }

  public JsonObject(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  public JsonObject(Map<String, ? extends JsonBase> m) {
    super(m);
  }

  public <T extends JsonBase> T getAs(String key, ObjectType<T> type) {
    return type.getObjectClass().cast(get(key));
  }
}
