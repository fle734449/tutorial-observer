package observer3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {

    public ComplementaryColorPanel(float hue, float saturation, float brightness) {
        super(hue, saturation, brightness);
        DisplayColors.originalColorPanel.addPropertyChangeListener(this);
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		float complementaryHue =  DisplayColors.originalColorPanel.getHue() - (float) 0.5;
		if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
		Color complementaryColor = Color.getHSBColor(complementaryHue, DisplayColors.originalColorPanel.getSaturation(), DisplayColors.originalColorPanel.getBrightness());
        this.setColor(complementaryColor);
	}


}