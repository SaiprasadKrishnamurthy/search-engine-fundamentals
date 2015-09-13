package vectorspacemodel.naive

import api.{Document, Frequency, Term, Vocabulary}

/**
 * Created by sai on 13/09/2015.
 */
object BitBasedVectorSpaceModel {

  def main(args: Array[String]) {

    val doc1 = Document("doc1","there is a news about ")
    val doc2 = Document("doc2","news about organic food campaign")
    val doc3 = Document("doc3","news of presidential campaign")
    val doc4 = Document("doc4","news of presidential campaign presidential candidate")
    val doc5 = Document("doc5","news of organic food campaign campaign campaign")
    val resultDocuments = List(doc1, doc2, doc3, doc4, doc5)

    val vocabulary = Vocabulary(resultDocuments)

    val query = "news about presidential campaign"

    val queryAsTerms = query.split(" ").map(Term).toList

    val frequency = Frequency(vocabulary)


    // Represent query vector and document vector in the vector space.
    // vocabulary as the base.
    val queryVector = vocabulary.allTerms.distinct.map(term => if(queryAsTerms.contains(term)) 1 else 0)

    // apply a dot product.
    val docsRanking = resultDocuments.map(doc =>
      doc -> queryVector.zip(doc.vector(vocabulary, queryAsTerms)).map(pair => pair._1 * pair._2).reduce(_ + _)
    )

    docsRanking.foreach(docRank => println(s"Document ${docRank._1.id} ==> ${docRank._2}"))

  }

}
