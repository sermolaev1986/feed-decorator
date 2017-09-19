package social_feed_decorator.decorator

import social_feed_decorator.entity.FeedEntity
import social_feed_decorator.render.RendererRegistry

/**
  * Takes parsed entities as input and outputs to string
  */
trait FeedDecorator {
  def decorateFeed(entities: Seq[FeedEntity]): String
}

class FeedDecoratorImpl(renderers: RendererRegistry) extends FeedDecorator {
  override def decorateFeed(entities: Seq[FeedEntity]): String = {
    entities
      .sortBy(_.startPosition)
      .map(entity => renderers.get(entity.entityType).render(entity.value))
      .mkString(" ")
  }
}
