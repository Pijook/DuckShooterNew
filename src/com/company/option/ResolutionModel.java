package com.company.option;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class ResolutionModel implements ComboBoxModel<Resolution> {

    private Resolution selectedResolution;
    private final List<Resolution> resolutions;

    public ResolutionModel() {
        this.resolutions = new ArrayList<>();
        resolutions.add(new Resolution(1280, 720));
        resolutions.add(new Resolution(1366, 768));
        resolutions.add(new Resolution(1920, 1080));
        resolutions.add(new Resolution(2560, 1080));

        selectedResolution = resolutions.get(0);
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedResolution = (Resolution) anItem;
    }

    @Override
    public Resolution getSelectedItem() {
        return selectedResolution;
    }

    @Override
    public int getSize() {
        return resolutions.size();
    }

    @Override
    public Resolution getElementAt(int index) {
        return resolutions.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public Resolution getSelectedResolution() {
        return selectedResolution;
    }

    public void setSelectedResolution(Resolution selectedResolution) {
        this.selectedResolution = selectedResolution;
    }
}
