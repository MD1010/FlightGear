package models;

public class XmlNode {
    public String name;
    public String format;
    public String type;
    public String node;
    public XmlNode(String name, String format, String type, String node) {
        this.name = name;
        this.format = format;
        this.type = type;
        this.node = node;
    }
}
