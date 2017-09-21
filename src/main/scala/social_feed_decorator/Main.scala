package social_feed_decorator

import social_feed_decorator.decorator.{FeedDecorator, FeedDecoratorImpl}
import social_feed_decorator.entity.FeedEntity
import social_feed_decorator.render._

object Main extends App {
  val renderers: RendererRegistry = new RendererRegistryImpl
  renderers.register("twitterUserName", new TwitterUserNameRenderer)
  renderers.register("noun", new NounRenderer)
  renderers.register("link", new LinkRenderer)

  val decorator: FeedDecorator = new FeedDecoratorImpl(renderers)

  val entities =
    Seq(
      FeedEntity(14, 22, "noun"),
      FeedEntity(0, 5, "noun"),
      FeedEntity(55, 67, "twitterUserName"),
      FeedEntity(37, 54, "link")
    )

  assert(
    decorator.decorateFeed("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile", entities) ==
      "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\"> http://bit.ly/xyz</a> @ <a href=\"http://twitter.com/elversatile\"> elversatile</a>"
  )

}
