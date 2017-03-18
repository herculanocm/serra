package br.com.cunha.serra.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name="produto")
@Entity(name="produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@Lob
	private String description;
	private int pages;
	
	@ElementCollection
	private List<Preco> prices = new ArrayList<Preco>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<Preco> getPrices() {
		return prices;
	}

	public void setPrices(List<Preco> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", title=" + title + ", description=" + description + ", pages=" + pages
				+ ", prices=" + prices + "]";
	}
	
	
	
}
