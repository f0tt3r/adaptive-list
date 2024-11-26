public class AdaptiveList {

    private int value;
    private AdaptiveList next;

    public AdaptiveList(int value, AdaptiveList next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public AdaptiveList getNext() {
        return this.next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(AdaptiveList next) {
        this.next = next;
    }

    public static AdaptiveList singletonList(int value) {
        return new AdaptiveList(value, null);
    }

    public boolean isLast() {
        return this.next == null;
    }

    public AdaptiveList prepend(int value) {
        AdaptiveList newHead = new AdaptiveList(value, this);
        return newHead;
    }

    public AdaptiveList append(int value) {
        if (this.next == null) {
            this.next = new AdaptiveList(value, null);
        } else {
            this.next.append(value);
        }
        return this;
    }

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        } else if (this.next != null) {
            return this.next.contains(value);
        } else {
            return false;
        }
    }

    public boolean containsAdaptive(int value) {
        if (this.next == null) {
            return false;
        }

        if (this.next.value == value) {
            AdaptiveList temp = this.next;
            this.next = temp.next;
            temp.next = this;
            return true;
        } else {
            return this.next.containsAdaptive(value);
        }
    }
}
