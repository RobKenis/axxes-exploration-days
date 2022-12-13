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
import javax.ws.rs.QueryParam


@Path("/chart")
class ChartResource {

    @GET
    @Path("/200.svg")
    @Produces("image/svg+xml")
    fun generate200m(@QueryParam("first") first: Double, @QueryParam("second") second: Double, @QueryParam("testName") testName: String): String {
        val dataset = DefaultCategoryDataset()
        dataset.addValue(first, testName, "100m")
        dataset.addValue(second, testName, "200m")
        return generateChart(dataset, "200 Meters")
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
        return generateChart(dataset, "400 Meters")
    }

    private fun generateChart(dataset: DefaultCategoryDataset, title: String): String {
        val chart: JFreeChart = ChartFactory.createLineChart(
                title,
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