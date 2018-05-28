package net.darmo_creations.json;

import java.util.ArrayList;
import java.util.Collection;

public final class JsonArray extends ArrayList<JsonBase> implements JsonBase {
  private static final long serialVersionUID = -5326812842277159880L;

  public JsonArray() {
    super();
  }

  public JsonArray(int initialCapacity) {
    super(initialCapacity);
  }

  public JsonArray(Collection<? extends JsonBase> c) {
    super(c);
  }

  public <T extends JsonBase> T getAs(int index, ObjectType<T> type) {
    return type.getObjectClass().cast(get(index));
  }
}
