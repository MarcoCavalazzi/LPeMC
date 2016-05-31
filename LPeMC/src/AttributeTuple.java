
public class AttributeTuple {

	protected int offset;
	protected String attributeName;
	protected String className;

	public AttributeTuple(String attributeName, String className, int offset) {
		this.attributeName = attributeName;
		this.className = className;
		this.offset = offset;
	}

	public void setOffset(int newOffset) {
		offset = newOffset;
	}

	public int getOffset() {
		return offset;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public String getClassName() {
		return className;
	}
}
