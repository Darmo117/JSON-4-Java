package net.darmo_creations.json;

public final class JsonValue implements JsonBase {
  private Object value;

  public JsonValue(Object value) {
    this.value = value;
  }

  public String getString() {
    return (String) this.value;
  }

  public Integer getInteger() {
    return (Integer) this.value;
  }

  public Double getDouble() {
    return (Double) this.value;
  }

  public Boolean getBoolean() {
    return (Boolean) this.value;
  }

  public boolean isNull() {
    return this.value == null;
  }

  public Class<?> getType() {
    return isNull() ? null : this.value.getClass();
  }
}
