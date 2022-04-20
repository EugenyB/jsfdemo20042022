package com.example.demo1;

import com.example.demo1.dto.PointDTO;
import com.example.demo1.model.Point;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class TabulateBean implements Serializable {

    private double start;
    private double finish;
    private double step;

    private List<Point> points = new ArrayList<>();


    public List<PointDTO> getPoints() {
        return points.stream().map(p -> new PointDTO(p.getX(), p.getY())).collect(Collectors.toList());
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getFinish() {
        return finish;
    }

    public void setFinish(double finish) {
        this.finish = finish;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public String tabulate() {
        points = new ArrayList<>();
        int n = (int) ((finish - start)/step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = Math.sin(x);
            points.add(new Point(x, y));
        }
        return "tabulation";
    }

}
