package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Bucket {

	private int id;
	private int userId;
	private int bookId;
	private LocalDate purchaseDate;
	
	public Bucket(int id, int userId, int bookId, LocalDate purchaseDate) {
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.purchaseDate = purchaseDate;
	}
	
	public Bucket(int userId, int bookId, LocalDate purchaseDate) {
		this.userId = userId;
		this.bookId = bookId;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, id, purchaseDate, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		return bookId == other.bookId && id == other.id && Objects.equals(purchaseDate, other.purchaseDate)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", purchaseDate=" + purchaseDate
				+ "]";
	}
	
}
