# Chain of Responsibility Pattern

## Intent
The Chain of Responsibility pattern passes requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## Problem
Imagine you're working on an online ordering system. You want to restrict access to the system so only authenticated users can create orders. Also, users who have administrative permissions should have unrestricted access to all orders.

You planned to implement these checks by performing them in sequence:
1. Authentication check
2. Authorization check  
3. Validation check
4. Caching check

However, the code became very messy. Each check was tightly coupled to the others, making it hard to add new checks or change the order of existing ones.

## Solution
The Chain of Responsibility pattern suggests that you link these request handlers into a chain. Each linked handler has a field for storing a reference to the next handler in the chain.

## Structure
- **Handler**: Declares the interface for handling requests and optionally implements the link to the next handler
- **Concrete Handler**: Contains the actual code for processing requests. Can decide whether to process a request or pass it along the chain
- **Client**: Composes chains and sends requests to the first handler in the chain

## Example: Support Ticket System
Our example implements a support ticket system where different levels of support staff handle tickets based on their priority:
- Level 1 Support: Handles basic tickets (priority 1-3)
- Level 2 Support: Handles intermediate tickets (priority 4-6)  
- Level 3 Support: Handles complex tickets (priority 7-10)

## Benefits
- **Decoupling**: The sender doesn't need to know which handler will process the request
- **Flexibility**: You can add or remove handlers dynamically
- **Single Responsibility**: Each handler focuses on one type of processing

## Drawbacks
- **No guarantee of handling**: A request might not be handled if no handler in the chain can process it
- **Performance**: Long chains can impact performance
- **Debugging**: Can be difficult to debug the flow through the chain

## When to Use
- When you want to give more than one object a chance to handle a request
- When you don't want to specify handlers explicitly in your code
- When the set of handlers should be specified dynamically