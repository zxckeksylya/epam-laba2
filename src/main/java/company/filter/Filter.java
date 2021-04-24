package company.filter;

public interface Filter<T> {
    boolean check(T value);
}
