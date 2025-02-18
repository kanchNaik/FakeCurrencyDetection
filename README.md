# Fake Currency Detection Using Image Processing and Machine Learning

## Overview
This project focuses on detecting counterfeit currency using image processing and machine learning techniques. The system is designed as an Android application that allows users to verify the authenticity of currency notes by capturing images and processing them using various algorithms.

## Features
- Image acquisition using a smartphone camera
- Image pre-processing (resizing, noise reduction, grayscale conversion)
- Edge detection and segmentation
- Feature extraction and classification using machine learning
- Random Forest algorithm for final decision-making
- User-friendly interface for quick results

## Technology Stack
- **Frontend:** Android (Java/Kotlin)
- **Backend:** Machine Learning, Image Processing (OpenCV)
- **Libraries Used:** OpenCV, Random Forest Algorithm
- **Development Tools:** Android Studio, Python (for model training)

## System Requirements
### Hardware:
- Android device with a camera (minimum 16MP recommended)

### Software:
- Android KitKat or higher
- OpenCV library
- Internet connectivity for remote processing (if applicable)

## Installation Guide
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/fake-currency-detection.git
   ```
2. Open the project in Android Studio.
3. Ensure OpenCV library dependencies are included.
4. Build and run the application on an Android device.

## Usage
1. Open the application.
2. Capture an image of the currency note.
3. The system processes the image using pre-processing techniques.
4. The extracted features are analyzed using a trained machine learning model.
5. The application displays whether the note is genuine or fake.

## Methodology
- **Pre-processing:** Image resizing, noise reduction (median filter), grayscale conversion.
- **Edge Detection:** Sobel Operator for feature enhancement.
- **Segmentation:** Adaptive thresholding to separate regions of interest.
- **Feature Extraction:** Extracting unique currency features like watermarks, security threads, and serial numbers.
- **Classification:** Random Forest algorithm determines authenticity based on trained data.

## Testing
- Unit Testing: Ensures individual components function correctly.
- Integration Testing: Checks the interaction between modules.
- System Testing: Validates the entire workflow from image capture to result display.
- Performance Testing: Measures the accuracy and response time.

## Future Enhancements
- Support for multiple currency denominations.
- Improved accuracy using deep learning models.
- Offline mode for faster processing.
- Expanded dataset for better model training.

## Contributors
- Sharwari Gothe
- Vrushal Joshi
- Ajmal Khan
- Kanchan Naik
- Guided by Mrs. Priya Shelke

## License
This project is licensed under the MIT License - see the LICENSE file for details.

