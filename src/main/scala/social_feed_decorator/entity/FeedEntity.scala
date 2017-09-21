package social_feed_decorator.entity

/**
  * Meta information of feed token
  *
  * @param startPosition - start index in original feed string
  * @param endPosition   - end index in original feed string
  * @param entityType    - type of token
  */
case class FeedEntity(startPosition: Int, endPosition: Int, entityType: String) {
}
