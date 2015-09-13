package api

/**
 * Created by sai on 13/09/2015.
 */
case class Document(id: String, contents: String) {

  private lazy val terms = contents.split(" ").map(Term(_))

  def allTerms = terms

  def vector(vocabulary: Vocabulary, query: List[Term]) = vocabulary.allTerms.distinct.map(term => if (query.contains(term) && allTerms.contains(term)) 1 else 0)
}
