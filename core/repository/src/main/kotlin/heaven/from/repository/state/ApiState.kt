package heaven.from.repository.state

sealed class ApiState<out R> {
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val error: String) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
}
