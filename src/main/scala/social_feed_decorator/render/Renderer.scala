package social_feed_decorator.render

/**
  * Renders one string to another
  */
trait Renderer {
  def render(value: String): String
}
