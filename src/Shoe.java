
public class Shoe {

	private int id = 0;
	private String brand = null;
	private String style = null;
	private Float price = 0f;
	// private String color = null;
	// private String size = null;

	public Shoe() {

	}

	public Shoe(int id, String brand, String style, Float price) {
		this.id = id;
		this.brand = brand;
		this.style = style;
		this.price = price;
		// this.color = color;
		// this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	/*
	 * public String getColor() { return color; }
	 * 
	 * public void setColor(String color) { this.color = color; }
	 * 
	 * public String getSize() { return size; }
	 * 
	 * public void setSize(String size) { this.size = size; }
	 */

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", brand=" + brand + ", style=" + style + ", price=" + price + "]";
	}

}
