package social_feed_decorator.render

import scala.collection.mutable

/**
  * Registry to lookup renderer by entity type
  */
trait RendererRegistry {
  def register(entityType: String, renderer: Renderer)

  def get(entityType: String): Renderer
}

class RendererRegistryImpl extends RendererRegistry {
  final private val registry = mutable.Map[String, Renderer]()

  override def register(entityType: String, renderer: Renderer): Unit = {
    registry.put(entityType, renderer)
  }

  override def get(entityType: String): Renderer = {
    registry.getOrElse(entityType, new SimpleRenderer)
  }
}
