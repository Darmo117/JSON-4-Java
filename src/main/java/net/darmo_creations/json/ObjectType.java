package net.darmo_creations.json;

import java.io.Serializable;

public final class ObjectType<T extends JsonBase> implements Serializable {
  private static final long serialVersionUID = 7068360356239378250L;

  public static final ObjectType<JsonObject> OBJECT = new ObjectType<>(JsonObject.class);
  public static final ObjectType<JsonArray> ARRAY = new ObjectType<>(JsonArray.class);
  public static final ObjectType<JsonValue> VALUE = new ObjectType<>(JsonValue.class);

  private final Class<T> objectClass;

  private ObjectType(Class<T> objectClass) {
    this.objectClass = objectClass;
  }

  public Class<T> getObjectClass() {
    return this.objectClass;
  }
}
