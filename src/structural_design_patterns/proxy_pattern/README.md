# Proxy Pattern

## Overview

The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. The proxy acts as an intermediary, allowing you to perform something either before or after the request gets through to the original object.

## Structure

- **Image** (Subject Interface): Defines common operations for both RealImage and ImageProxy
- **RealImage** (RealSubject): The actual object that performs expensive operations (image loading)
- **ImageProxy** (Proxy): Controls access to RealImage, provides lazy loading, caching, and additional features

## Key Benefits

- **Controlled Access**: Controls access to the original object
- **Lazy Loading**: Creates expensive objects only when needed
- **Caching**: Avoids repeated expensive operations
- **Additional Functionality**: Can add logging, validation, or security without modifying the original object
- **Resource Management**: Optimizes memory and processing resources

## Example Usage

The image loading system example demonstrates how the proxy:
- Provides lazy loading for expensive image operations
- Implements caching to avoid reloading images
- Offers additional features like preloading and status checking
- Controls when the real image object is created and used

## Without Proxy vs With Proxy

**Without Proxy**: All images are loaded immediately, consuming resources even if never displayed
**With Proxy**: Images are loaded only when displayed, with caching for subsequent access

## Types of Proxies Demonstrated

- **Virtual Proxy**: Controls expensive object creation (our main example)
- **Smart Proxy**: Adds additional functionality like preloading and status checking

## Running the Example

```bash
javac structural_design_patterns/proxy_pattern/example/*.java
java structural_design_patterns.proxy_pattern.example.ProxyPatternExample
```