package social_feed_decorator.decorator

import social_feed_decorator.entity.FeedEntity
import social_feed_decorator.render.RendererRegistry

/**
  * Takes parsed entities as input and outputs to string
  */
trait FeedDecorator {
  def decorateFeed(rawFeed: String, entities: Seq[FeedEntity]): String
}

class FeedDecoratorImpl(renderers: RendererRegistry) extends FeedDecorator {
  override def decorateFeed(rawFeed: String, entities: Seq[FeedEntity]): String = {
    val positionToRendererMapping = entities
      .map(entity => (entity.startPosition, renderers.get(entity.entityType)))
      .toMap

    val splitPositions = entities
      .sortBy(_.startPosition)
      .flatMap(entity => Seq(entity.startPosition, entity.endPosition))
      .toList

    (splitPositions zip splitPositions.tail)
      .map { case (a, b) => (positionToRendererMapping.get(a), rawFeed.substring(a, b)) }
      .map { case (renderer, token) => renderer.map(_.render(token)).getOrElse(token) }
      .mkString("")
  }
}
