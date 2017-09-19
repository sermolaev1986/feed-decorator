package social_feed_decorator.entity

/**
  * Part of feed parsed with meta information
  *
  * @param startPosition - start index in original feed string
  * @param endPosition   - end index in original feed string
  * @param value         - token string extracted from original feed string
  * @param entityType    - type of token
  */
case class FeedEntity(startPosition: Int, endPosition: Int, value: String, entityType: String) {
}
