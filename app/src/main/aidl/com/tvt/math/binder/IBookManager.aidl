// IBookManager.aidl
package com.tvt.math.binder;

parcelable Book;

interface IBookManager {

    void addBook(inout Book book);

    void deleteBook(inout Book book);

    List<Book> getBooks();
}
