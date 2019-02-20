package sort;

public enum SortType {
    /**
     * DESC 降序
     * ASC 升序
     */
    DESC(true), ASC(false);

    private boolean value;

    SortType(boolean b) {
        this.value = b;
    }

    public boolean isValue() {
        return value;
    }
}
