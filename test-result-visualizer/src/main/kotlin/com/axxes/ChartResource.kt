package com.axxes

import org.jfree.chart.ChartFactory
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.svg.SVGGraphics2D
import java.awt.geom.Rectangle2D
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces


@Path("/chart")
class ChartResource {

    @GET
    @Path("/200.svg")
    @Produces("image/svg+xml")
    fun generate200m(): String {
        val dataset = DefaultCategoryDataset()
        dataset.addValue(106.0, "nov 22", "100m")
        dataset.addValue(116.0, "nov 22", "200m")
        dataset.addValue(106.0, "feb 22", "100m")
        dataset.addValue(119.0, "feb 22", "200m")
        val chart: JFreeChart = ChartFactory.createLineChart(
                "200 Meters",
                "Distance in meters",
                "Time in seconds",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        )
        val g2 = SVGGraphics2D(720.0, 480.0)
        val area = Rectangle2D.Double(0.0, 0.0, 720.0, 480.0)
        chart.draw(g2, area)
        return g2.svgElement
    }

    @GET
    @Path("/400.svg")
    @Produces("image/svg+xml")
    fun generate400m(): String {
        val dataset = DefaultCategoryDataset()
        dataset.addValue(106.0, "nov 22", "100m")
        dataset.addValue(121.0, "nov 22", "200m")
        dataset.addValue(126.0, "nov 22", "300m")
        dataset.addValue(120.0, "nov 22", "400m")
        dataset.addValue(116.0, "feb 22", "100m")
        dataset.addValue(129.0, "feb 22", "200m")
        dataset.addValue(130.0, "feb 22", "300m")
        dataset.addValue(128.0, "feb 22", "400m")
        val chart: JFreeChart = ChartFactory.createLineChart(
                "400 Meters",
                "Distance in meters",
                "Time in seconds",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        )
        val g2 = SVGGraphics2D(720.0, 480.0)
        val area = Rectangle2D.Double(0.0, 0.0, 720.0, 480.0)
        chart.draw(g2, area)
        return g2.svgElement
    }

}