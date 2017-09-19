package social_feed_decorator.render

/**
  * Renderer implementations
  */
class SimpleRenderer extends Renderer {
  override def render(value: String): String = {
    value
  }
}

class TwitterUserNameRenderer extends Renderer {
  override def render(value: String): String = {
    "@ <a href=\"http://twitter.com/" + value + "\"> " + value + "</a>"
  }
}

class NounRenderer extends Renderer {
  override def render(value: String): String = {
    "<strong>" + value + "</strong>"
  }
}

class LinkRenderer extends Renderer {
  override def render(value: String): String = {
    "<a href=\"" + value + "\"> " + value + "</a>"
  }
}