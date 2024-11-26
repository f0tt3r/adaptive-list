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

    public setValue(int value) {
        this.value = value;
    }

    public setNext(AdaptiveList next) {
        this.next = next;
    }
}
