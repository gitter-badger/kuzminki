package kuzminki.model.insert

trait RunReturning[S, R]

trait InsertReturning[S, R] extends RunReturning[S, R]

trait UpsertReturning[S, R] extends RunReturning[S, R]