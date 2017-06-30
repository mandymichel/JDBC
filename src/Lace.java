public class Lace {

	private int id = 0;
	private String color = null;
	private Float price = 0f;
	private String style = null;

	public Lace() {

	}

	public Lace(int id, String color, Float price, String style) {
		this.id = id;
		this.color = color;
		this.price = price;
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Lace [id=" + id + ", color=" + color + ", price=" + price + ", style=" + style + "]";
	}

}
