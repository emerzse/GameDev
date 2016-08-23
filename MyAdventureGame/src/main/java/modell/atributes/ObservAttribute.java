package modell.atributes;

import java.util.Map;

public interface ObservAttribute {
	public void updateAdd(Map<Attribute, Integer> itemAtrMap);
	public void updateExtract(Map<Attribute, Integer> itemAtrMap);
}
