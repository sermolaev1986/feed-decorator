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
      FeedEntity(14, 22, "Facebook", "noun"),
      FeedEntity(7, 14, "visited", "verb"),
      FeedEntity(0, 5, "Obama", "noun"),
      FeedEntity(24, 37, "headquarters:", "someAnotherType"),
      FeedEntity(55, 67, "elversatile", "twitterUserName"),
      FeedEntity(37, 54, "http://bit.ly/xyz", "link")
    )

  assert(
    decorator.decorateFeed(entities) ==
      "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\"> http://bit.ly/xyz</a> @ <a href=\"http://twitter.com/elversatile\"> elversatile</a>"
  )

}
