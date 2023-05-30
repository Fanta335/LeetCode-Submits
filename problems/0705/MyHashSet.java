class MyHashSet {
  boolean[] values;

  public MyHashSet() {
    values = new boolean[1000001];
  }

  public void add(int key) {
    values[key] = true;
  }

  public void remove(int key) {
    values[key] = false;
  }

  public boolean contains(int key) {
    return values[key] == true;
  }
}
