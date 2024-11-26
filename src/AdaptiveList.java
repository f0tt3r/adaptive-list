public class AdaptiveList {
    // Klasse ist öffentlich, damit sie außerhalb des Pakets zugänglich ist

    private int value;
    private AdaptiveList next;
    // Felder sind privat, um Kapselung zu gewährleisten und direkte Manipulation zu verhindern

    public AdaptiveList(int value, AdaptiveList next) {
        this.value = value;
        this.next = next;
    }
    // Konstruktor ist öffentlich, um Instanzierung der Klasse von außen zu ermöglichen

    public int getValue() {
        return this.value;
    }
    // Öffentliche Methode, um den Wert des Knotens abzurufen

    public AdaptiveList getNext() {
        return this.next;
    }
    // Öffentliche Methode, um den nächsten Knoten abzurufen

    public void setValue(int value) {
        this.value = value;
    }
    // Öffentliche Methode, um den Wert des Knotens zu setzen

    public void setNext(AdaptiveList next) {
        this.next = next;
    }
    // Öffentliche Methode, um den nächsten Knoten zu setzen

    public void prepend(int value) {
        AdaptiveList newHead = new AdaptiveList(this.value, this.next);
        this.value = value;
        this.next = newHead;
    }
    // Öffentliche Methode, um ein Element am Anfang der Liste hinzuzufügen

    public boolean isLast() {
        return this.next == null;
    }
    // Öffentliche Methode, um zu prüfen, ob dies der letzte Knoten ist

    public static AdaptiveList singletonList(int value) {
        return new AdaptiveList(value, null);
    }
    // Statische Methode, um eine Liste mit einem einzigen Element zu erstellen, ohne Instanz der Klasse

    public AdaptiveList append(int value) {
        if (this.next == null) {
            this.next = new AdaptiveList(value, null);
        } else {
            this.next.append(value);
        }
        return this;
    }
    // Öffentliche Methode, um ein Element am Ende der Liste hinzuzufügen

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        } else if (this.next != null) {
            return this.next.contains(value);
        } else {
            return false;
        }
    }
    // Öffentliche Methode, um zu prüfen, ob die Liste einen bestimmten Wert enthält

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
    // Öffentliche Methode, um rekursiv zu prüfen, ob die Liste einen Wert enthält und diesen Knoten adaptiv verschiebt

    public boolean containsTopPriority(int value) {
        if (this.value == value) {
            return true;
        } else if (this.next != null && this.next.value == value) {
            AdaptiveList foundNode = this.next;
            this.next = foundNode.next;
            foundNode.next = this;
            return true;
        } else if (this.next != null) {
            boolean found = this.next.containsTopPriority(value);
            if (found) {
                AdaptiveList foundNode = this.next;
                this.next = foundNode.next;
                foundNode.next = this;
            }
            return found;
        } else {
            return false;
        }
    }
    // Öffentliche Methode, um zu prüfen, ob die Liste einen Wert enthält und diesen Knoten als ersten Knoten setzt
}