import java.util.*;

class BrowserHistory {
  Stack<String> prev;
  Stack<String> next;

  public BrowserHistory(String homepage) {
    this.prev = new Stack<>();
    this.next = new Stack<>();
    this.prev.push(homepage);
  }

  public void visit(String url) {
    this.prev.push(url);
    this.next.clear();
  }

  public String back(int steps) {
    while (steps > 0 && this.prev.size() > 1) {
      this.next.push(this.prev.pop());
      steps--;
    }
    return this.prev.peek();
  }

  public String forward(int steps) {
    while (steps > 0 && !this.next.isEmpty()) {
      this.prev.push(this.next.pop());
      steps--;
    }
    return this.prev.peek();
  }
}
