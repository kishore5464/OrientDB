package com.kishore.orientDB.models;

import javax.persistence.Id;

public class Books {

	@Id
	private Long bookId;
	private String bookName;
	private Double pricePerUnit;
	private Long authorId;

	public Books() {
		super();
	}

	public Books(Long bookId, String bookName, Double pricePerUnit, Long authorId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.pricePerUnit = pricePerUnit;
		this.authorId = authorId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", pricePerUnit=" + pricePerUnit + ", authorId="
				+ authorId + "]";
	}

}
