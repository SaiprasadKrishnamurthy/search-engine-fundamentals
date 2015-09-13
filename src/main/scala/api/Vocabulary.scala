package api

/**
 * Created by sai on 13/09/2015.
 */
case class Vocabulary (documents: List[Document]) {
  def allTerms = documents.flatMap(doc => doc.allTerms)
}
